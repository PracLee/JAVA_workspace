<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>

<%@ attribute name="ad01_src" required="true"%>
<%@ attribute name="ad02_src" required="true"%>
<%@ attribute name="ad03_src" required="true"%>
<%@ attribute name="ad01_href" required="true"%>
<%@ attribute name="ad02_href" required="true"%>
<%@ attribute name="ad03_href" required="true"%>

<div id="adContainer">
<p>광고</p>
	<div id="ad01" class="ad">
		<a href="${ad01_href}"> <img class="ad_img" alt="광고 1"
			src="${ad01_src}">
		</a>
	</div>
	<div id="ad02" class="ad">
		<a href="${ad02_href}"> <img class="ad_img" alt="광고 2"
			src="${ad02_src}">
		</a>
	</div>
	<div id="ad02" class="ad">
		<a href="${ad03_href}"> <img class="ad_img" alt="광고 3"
			src="${ad03_src}">
		</a>
	</div>
</div>