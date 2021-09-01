package com.test.controller;

import com.github.pagehelper.PageInfo;
import com.test.pojo.Goods;
import com.test.pojo.GoodsSku;
import com.test.pojo.SolrPager;
import com.test.service.IGoodsService;
import com.test.service.IGoodsSkuService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private HttpSolrClient httpSolrClient;

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IGoodsSkuService goodsSkuService;

    public IGoodsSkuService getGoodsSkuService() {
        return goodsSkuService;
    }

    public void setGoodsSkuService(IGoodsSkuService goodsSkuService) {
        this.goodsSkuService = goodsSkuService;
    }

    public HttpSolrClient getHttpSolrClient() {
        return httpSolrClient;
    }

    public void setHttpSolrClient(HttpSolrClient httpSolrClient) {
        this.httpSolrClient = httpSolrClient;
    }

    public IGoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("/showGoodsByWhere")
    public ModelAndView showGoodsByWhere(@RequestParam(name = "pageIndex",defaultValue = "1") int pageIndex, int cid){

        //获得cid 查询改类别下的商品信息
        PageInfo<Goods> pageInfo=goodsService.selectGoodsByWhere(cid,pageIndex,3);

        //传到视图页
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("search");

        modelAndView.addObject("cid",cid);

        return modelAndView;

    }

    @RequestMapping("/showGoodsByWhereBySolr")
    public ModelAndView showGoodsByWhereBySolr(@RequestParam(name = "pageIndex",defaultValue = "1") int pageIndex,@RequestParam(name = "cid",defaultValue = "0") int cid,@RequestParam(name = "keyword",defaultValue = "") String keyword) throws SolrServerException, IOException {

        //通过solr客户端 查询 数据
        //1 创建一个查询对象
        SolrQuery solrQuery = new SolrQuery();
        //2 设置默认查询的字段
        solrQuery.set("df","goodsName");
        if(keyword=="")
            solrQuery.setQuery("*");
        else
            solrQuery.setQuery(keyword+"*");
        //3 设置过滤条件
        if(cid!=0)
            solrQuery.setFilterQueries("cid:"+cid);
        //4 设置组装的字段
        solrQuery.addField("id");
        solrQuery.addField("goodsName");
        solrQuery.addField("salesPrice");
        solrQuery.addField("goodsImg");

        //5 设置查询分页数据
        int pageSize=2;
        //设置偏移量
        solrQuery.setStart((pageIndex-1)*pageSize);
        //设置每页大小
        solrQuery.setRows(pageSize);

        //将查询对象传到服务器端
        QueryResponse queryResponse=httpSolrClient.query(solrQuery);

        httpSolrClient.commit();

        //返回查询到的当前页数据
        List<Goods> goodsList = queryResponse.getBeans(Goods.class);

        //返回的是总记录数
        long recordCount = queryResponse.getResults().getNumFound();

        //组装分页类对象
        SolrPager solrPager = new SolrPager();

        solrPager.setPageIndex(pageIndex);
        solrPager.setPageSize(pageSize);
        solrPager.setGoodsList(goodsList);
        solrPager.setRecordCount(recordCount);
        //计算总页数
        int pageCount = (int)Math.ceil((double)recordCount/pageSize);
        solrPager.setPageCount(pageCount);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("solrPager",solrPager);

        modelAndView.addObject("cid",cid);

        modelAndView.addObject("keyword",keyword);

        modelAndView.setViewName("search2");

        return modelAndView;

    }

    @RequestMapping("/selectGoodsByGoodsId")
    public ModelAndView selectGoodsByGoodsId(int goodsId){
        //根据id查询商品的详细信息
        Goods goods = goodsService.selectGoodsByGoodsId(goodsId);
        //转发到视图页
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("introduction");
        modelAndView.addObject("goods",goods);
        return modelAndView;

    }

    @RequestMapping("/getSkuGoods")
    @ResponseBody
    public GoodsSku getSkuGoods(String sku_properties, int goodsId){

        GoodsSku goodsSku=goodsSkuService.getGoodsSku(goodsId,sku_properties);
        return goodsSku;

    }
}
