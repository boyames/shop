package com.test.controller;

import com.test.pojo.Cart;
import com.test.pojo.CartInfo;
import com.test.pojo.Users;
import com.test.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    public ICartService getCartService() {
        return cartService;
    }

    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }

    /**
     * @ResponseBody:用ajax返回数据
     */
    @RequestMapping("/addGoodsToCart")
    @ResponseBody
    public int addGoodsToCart(int skuId, int buyNum, HttpServletRequest request){

        HttpSession session = request.getSession();

        if(session.getAttribute("loginUser")!=null){

            //1.如果登入了，从session中取出cartId
            Users users=(Users) session.getAttribute("loginUser");
            int cartId = users.getCart().getCartId();
            //2.将skuId，buyNum，cartId组装成CartInfo对象
            CartInfo cartInfo = new CartInfo(cartId,skuId,buyNum);
            //3.交给service处理
            int totalNum = cartService.addGoodsToCart(cartInfo);

            //更新session中的信息
            Cart cart=users.getCart();
            cart.setTotalNum(totalNum);
            users.setCart(cart);

            session.setAttribute("loginUser",users);

            return totalNum;
        }
        else
            return -1;

    }

    @RequestMapping("/deleteGoodsFromCart")
    @ResponseBody
    public int deleteGoodsFromCart(int skuId,HttpServletRequest request){

        //获得cartId
        HttpSession session = request.getSession();

        if(session.getAttribute("loginUser")!=null){

            Users users=(Users) session.getAttribute("loginUser");

            int cartId=users.getCart().getCartId();

            CartInfo cartInfo=new CartInfo(cartId,skuId);

            int totalNum = cartService.deleteGoodsFromCart(cartInfo);

            users.getCart().setTotalNum(totalNum);

            session.setAttribute("loginUser",users);//保证session数据一起更新

            return totalNum;
        }
        else {
                return -1;
        }
    }

    @RequestMapping("/showCartList")
    public ModelAndView showCartList(HttpServletRequest request){

        //查询该购物车的详细信息
        //鲜先获得cartId
        HttpSession session=request.getSession();
        if (session.getAttribute("loginUser")!=null){

            //鲜先获得cartId
            Users users=(Users) session.getAttribute("loginUser");

            int cartId = users.getCart().getCartId();
            //传到service查询完整的购物车信息
            Cart cart = cartService.selectCartList(cartId);
            System.out.println(cart);
            //转发到shopcart页面

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("cart",cart);
            modelAndView.setViewName("shopcart");

            return modelAndView;
        }
        else {
            //没有登入 跳转到登入页面
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;
        }

    }
}
