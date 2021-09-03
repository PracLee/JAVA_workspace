<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>

<%@ attribute name="product"%>
<%@ attribute name="many"%>
<%@ attribute name="color"%>
<%@ attribute name="fontSize"%>
<h2 style="color :${color }; font-size:${fontSize };">구매하신 물품은
	${product }이고, ${many }개 구매하셧습니다.</h2>
<h2 style="color :${color }; font-size:${fontSize };">총가격은
	${many*PVO.printPrice(product) }원 입니다.</h2>