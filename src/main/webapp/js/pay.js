
$(function (){

    //提交订单
    $("#J_Go").click(function (){

        //1. 获得地址id
        var addressId=$("li.defaultAddr").find(":hidden").val();
        //2. 获得选中的商品id
        var arr=$(".skuId");
        var skuIdStr="";
        arr.each(function (){
            skuIdStr=$(this).val()+",";
        })
        skuIdStr=skuIdStr.substr(0,skuIdStr.length-1);
        //3. 获得订单金额
        var orderAmount=$("#J_ActualFee").html();
        //4. 提交到服务端处理
        $.get("http://localhost:8080/testShop/order/addOrder?addressId="+addressId+"&skuIdStr="+skuIdStr+"&orderAmount="+orderAmount,function (msg){

            //alert(msg);
            //跳转到付款页面
            location.href="http://localhost:8080/testShop/pay/alipayTradePagePay?orderId="+msg+"&orderAmount="+orderAmount;

        })
    })
})