<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Add Scheme</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/image/favicon.png" />
</head>

<body class="sidebar-light">
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->

		<jsp:include page="header.jsp"></jsp:include>

		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->

			<jsp:include page="menu.jsp"></jsp:include>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row grid-margin">
						<div class="col-12">
							<div class="card">
								
							</div>
						</div>
					</div>
					<div class="row grid-margin">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Admin | Manage Schemes</h4>
									<f:form  method="post" action="insertScheme" modelAttribute="SchemeVO">
										<fieldset>
											<div class="form-group">
												
												<label>Ministry Name</label>
												<f:select path="ministryVO.ministryId" class="form-control">
    											<f:options var="i" items="${ministryList}" itemValue="ministryId" itemLabel="ministryName" />
												</f:select><br>
												
												<label>Department Name</label>
												<f:select path="departmentVO.departmentId" class="form-control">
    											<f:options var="i" items="${departmentList}" itemValue="departmentId" itemLabel="departmentName" />
												</f:select><br>
												
												<label>Algorithm</label>
												 <f:select path="algorithmName" class="form-control">
												 <f:option value="Ministry1"></f:option>
					`							 <f:option value="Ministry2"></f:option>
												 <f:option value="Ministry3"></f:option>
												 <f:option value="Ministry4"></f:option>
												 <f:option value="Ministry5"></f:option>
												 <f:option value="Ministry6"></f:option>
												 <f:option value="Ministry7"></f:option>
												 <f:option value="Ministry8"></f:option>
												 <f:option value="Ministry9"></f:option>
												 <f:option value="Ministry10"></f:option>
												 </f:select><br>
												
												<label for="cname">Scheme Link</label> <f:input id="cname" class="form-control"
													path="schemeLink" minlength="2" type="text" /> <br>
													
													<f:hidden path="schemeId"/>
												 
											
											</div>
												
														<input class="btn btn-primary" type="submit" value="Submit">
										</fieldset>
									</f:form>
								</div>
							</div>
						</div>
					</div>
						</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->
				
				<jsp:include page="footer.jsp"></jsp:include>
				
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.min.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/bootstrap-maxlength.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<%=request.getContextPath()%>/adminResources/js/form-validation.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
