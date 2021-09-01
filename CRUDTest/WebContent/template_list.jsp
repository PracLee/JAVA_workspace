<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.post.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="datas" class="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="left-sidebar is-preload">
	<div id="page-wrapper">
		<!-- Main -->
		<section id="main">
			<div class="container">
				<!-- Sidebar -->
				<div id="sidebar" class="col-4 col-12-medium">
					<!-- Excerpts -->
					<section>

						<ul class="divided">
							<%
								for (PostVO vo : (ArrayList<PostVO>) datas) {
							%>
							<li>
								<!-- Excerpt -->
								<article class="box excerpt">
									<header>
										<h3>
											<a href="#">제목 : <%=vo.getTitle()%></a> <a href="#">작성자 :
												<%=vo.getId()%></a> <a href="#">작성일 : <%=vo.getPostdate()%></a>
										</h3>
									</header>
									<p><%=vo.getContent()%></p>
								</article>
							</li>
							<%
								}
							%>
							<%
								if (session.getAttribute("ID") == null) {
							%>
							<li>
								<!-- Excerpt -->
								<article class="box excerpt">
									<header>
										<h3>
											<a href="joinus.jsp">회원가입</a>
										</h3>
									</header>
								</article>
							</li>
							<li>
								<!-- Excerpt -->
								<article class="box excerpt">
									<header>
										<h3>
											<a href="login.jsp">로그인</a>
										</h3>
									</header>
								</article>
							</li>
							<%
								} else {
							%>
							<li>
								<!-- Excerpt -->
								<article class="box excerpt">
									<header>
										<h3>
											<a href="post.jsp">글쓰기</a>
										</h3>
									</header>
								</article>
							</li>
							<li>
								<!-- Excerpt -->
								<article class="box excerpt">
									<header>
										<h3>
											<a href="control.jsp?action=mypage">내가 쓴 글 보기</a>
										</h3>
									</header>
								</article>
							</li>
							<li>
								<!-- Excerpt -->
								<article class="box excerpt">
									<header>
										<h3>
											<a href="control.jsp?action=logout">로그아웃</a>
										</h3>
									</header>
								</article>
							</li>

							<%
								}
							%>
						</ul>
					</section>

				</div>
<!-- Footer -->
				<section id="footer">
					<div class="container">
						<div class="row">
							<div class="col-6 col-12-medium">
								<section>
									<form method="post" action="control.jsp?action=find">
										<div class="row gtr-50">
											<div class="col-6 col-12-small">
												<input name="index" placeholder="검색어 입력"type="text" />
												<input type = "submit" value = "검색하기">
											</div>
										</div>
									</form>
								</section>
							</div>
						</div>
					</div>
					</section>
					<div id="copyright" class="container">
						<ul class="links">
							<li>&copy; Untitled. All rights reserved.</li>
							<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</div>
			</div>
		</section>


	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>