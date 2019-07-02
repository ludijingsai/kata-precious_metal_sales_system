package com.coding.sales;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.coding.datemoudle.Member;
import com.coding.datemoudle.Product;
import com.coding.sales.input.OrderCommand;
import com.coding.sales.input.OrderItemCommand;
import com.coding.sales.input.PaymentCommand;
import com.coding.sales.output.DiscountItemRepresentation;
import com.coding.sales.output.OrderItemRepresentation;
import com.coding.sales.output.OrderRepresentation;
import com.coding.sales.output.PaymentRepresentation;

public class OrderPrint {
    public static OrderRepresentation printOrder(OrderCommand command)
    {
    	OrderRepresentation result = null;
    	List<OrderItemRepresentation> orderItemRepList=new ArrayList();
    	List<DiscountItemRepresentation> discountRepList=new ArrayList();
    	List<String> discountCards=new ArrayList();
    	List<PaymentRepresentation>  paymentCommandRepList=new ArrayList();
    	Map member=Member.getMember(command.getMemberId());
    	System.out.println(member);
    	List discountList =command.getDiscounts();
    	BigDecimal productNum=new BigDecimal("0");
        List<OrderItemCommand> orderItem=command.getItems();
        BigDecimal totalPriceRep=new BigDecimal("0");
        BigDecimal totalDiscountPrice=new BigDecimal("0");
        if(orderItem!=null&&orderItem.size()>0)
        {
        	for(OrderItemCommand item:orderItem)
        	{
        		Map product=Product.getProduct(item.getProduct());
        		String price=(String) product.get("Price");
        		String fullreductionStr=(String) product.get("fullreduction");
        		//商品清单
        		BigDecimal priceBigDecimal  =new BigDecimal(price);
        		BigDecimal amountBigDecimal=item.getAmount();
        		BigDecimal subTotal=priceBigDecimal.multiply(amountBigDecimal);
        		OrderItemRepresentation orderItemRepresentation =new OrderItemRepresentation(item.getProduct(), (String) product.get("Name"), priceBigDecimal, amountBigDecimal, subTotal);
        		totalPriceRep=totalPriceRep.add(subTotal);
        		orderItemRepList.add(orderItemRepresentation);
        		productNum=totalPriceRep.add(productNum);
        		//优惠明细
        		String preferential=(String) product.get("preferential");
        		if(preferential!=null&&preferential.equals("1"))
        		{
        			for(int i = 0, l = discountList.size(); i < l; ++i) {
        			   String discountStr = (String) discountList.get(i);
        			   if(discountStr.equals("9折优惠券"))
        			   {
        				   BigDecimal ninedi  =new BigDecimal("0.9");
        				   BigDecimal discountMon=subTotal.multiply(ninedi);
        				   DiscountItemRepresentation discountIteRep=new DiscountItemRepresentation(item.getProduct(), (String)product.get("Name"), discountMon);
        				   discountRepList.add(discountIteRep);
        	        		System.out.println(discountMon);
        				   totalDiscountPrice=totalDiscountPrice.add(discountMon);
        				   discountCards.add(discountStr);
        				   discountList.remove(i);
        				   break;
        			   }
        			}
        		}
        		if(preferential!=null&&preferential.equals("2"))
        		{
        			for(int i = 0, l = discountList.size(); i < l; ++i) {
        			   String discountStr = (String) discountList.get(i);
        			   if(discountStr.equals("95折优惠券"))
        			   {
        				   BigDecimal ninedi  =new BigDecimal("0.95");
        				   BigDecimal discountMon=subTotal.multiply(ninedi);
        				   DiscountItemRepresentation discountIteRep=new DiscountItemRepresentation(item.getProduct(), (String)product.get("Name"), discountMon);
        				   discountRepList.add(discountIteRep);
        				   totalDiscountPrice=totalDiscountPrice.add(discountMon);
        				   discountCards.add(discountStr);
        				   discountList.remove(i);
        				   break;
        			   }
        			}
        		}
        	}
        }
        for(OrderItemCommand item:orderItem)
        {
        	Map product=Product.getProduct(item.getProduct());
	
        }
        BigDecimal receivables = totalPriceRep.subtract(totalDiscountPrice);
        String memberTypeStr=(String)member.get("cardType");
        String cardPointsStr=(String)member.get("cardPoints");
        int memberPointsIncreased=0;
        int memberPoints=0;
        BigDecimal cardPointsBig=new BigDecimal(cardPointsStr);
        BigDecimal type1=new BigDecimal("1.5");
        BigDecimal type2=new BigDecimal("1.8");
        BigDecimal type3=new BigDecimal("2");
        BigDecimal num1=new BigDecimal("10000");
        BigDecimal num2=new BigDecimal("50000");
        BigDecimal num3=new BigDecimal("100000");
        String newMemberType="";
        if(memberTypeStr.equals("0"))
        {
        	cardPointsBig=cardPointsBig.add(receivables);
        	memberPointsIncreased=receivables.intValue();
        	memberPoints=cardPointsBig.intValue();
        	int comperint=cardPointsBig.compareTo(num1);
        	int comperint2=cardPointsBig.compareTo(num2);
        	int comperint3=cardPointsBig.compareTo(num3);
        	if(comperint<0)
        	{
        		newMemberType="0";
        	}
        	if(comperint>0&&comperint2<0)
        	{
        		newMemberType="1";
        	}
        	if(comperint2>0&&comperint3<0)
        	{
        		newMemberType="2";
        	}
        	if(comperint3>0)
        	{
        		newMemberType="3";
        	}
        	
        }
        else if(memberTypeStr.equals("1"))
        {
        	cardPointsBig=cardPointsBig.add(receivables.multiply(type1));
        	memberPointsIncreased=receivables.multiply(type1).intValue();
        	memberPoints=cardPointsBig.intValue();
        	int comperint=cardPointsBig.compareTo(num1);
        	int comperint2=cardPointsBig.compareTo(num2);
        	int comperint3=cardPointsBig.compareTo(num3);
        	if(comperint<0)
        	{
        		newMemberType="0";
        	}
        	if(comperint>0&&comperint2<0)
        	{
        		newMemberType="1";
        	}
        	if(comperint2>0&&comperint3<0)
        	{
        		newMemberType="2";
        	}
        	if(comperint3>0)
        	{
        		newMemberType="3";
        	}
        	
        }
        	else if(memberTypeStr.equals("2"))
        	{
        		cardPointsBig=cardPointsBig.add(receivables.multiply(type2));
        		memberPointsIncreased=receivables.multiply(type2).intValue();
        		memberPoints=cardPointsBig.intValue();
            	int comperint=cardPointsBig.compareTo(num1);
            	int comperint2=cardPointsBig.compareTo(num2);
            	int comperint3=cardPointsBig.compareTo(num3);
            	if(comperint<0)
            	{
            		newMemberType="0";
            	}
            	if(comperint>0&&comperint2<0)
            	{
            		newMemberType="1";
            	}
            	if(comperint2>0&&comperint3<0)
            	{
            		newMemberType="2";
            	}
            	if(comperint3>0)
            	{
            		newMemberType="3";
            	}
        	}
        		else if(memberTypeStr.equals("3"))
        		{
        			cardPointsBig=cardPointsBig.add(receivables.multiply(type3));
        			memberPointsIncreased=receivables.multiply(type3).intValue();
        			memberPoints=cardPointsBig.intValue();
                	int comperint=cardPointsBig.compareTo(num1);
                	int comperint2=cardPointsBig.compareTo(num2);
                	int comperint3=cardPointsBig.compareTo(num3);
                	if(comperint<0)
                	{
                		newMemberType="0";
                	}
                	if(comperint>0&&comperint2<0)
                	{
                		newMemberType="1";
                	}
                	if(comperint2>0&&comperint3<0)
                	{
                		newMemberType="2";
                	}
                	if(comperint3>0)
                	{
                		newMemberType="3";
                	}
        		}
        List<PaymentCommand> payCommandList=command.getPayments();
        for(PaymentCommand item:payCommandList)
        {
        	PaymentRepresentation payRep=new PaymentRepresentation(item.getType(), item.getAmount());
        	paymentCommandRepList.add(payRep);
        }	
        System.out.println(totalDiscountPrice);
        result=new OrderRepresentation(command.getOrderId(), Utils.getDate(command.getCreateTime()), command.getMemberId(), (String)member.get("cardName"), (String)member.get("cardType"), newMemberType, memberPointsIncreased, memberPoints, orderItemRepList, totalPriceRep, discountRepList, totalDiscountPrice, receivables, paymentCommandRepList, discountCards);
		return result;
    	
    }
}
