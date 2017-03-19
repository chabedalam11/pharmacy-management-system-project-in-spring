<jsp:include page="layout/header.jsp" />
<jsp:include page="layout/topNav.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<!-- page-wrapper -->
	<div id="page-wrapper">
	
		<!-- container-fluid -->
		<div class="container-fluid">
		
		
				<!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-5">
                        <h3 class="page-header">
                             <i class="fa fa-stethoscope" aria-hidden="true"></i>&emsp; Generic Code Initialization
                        </h3>
                    </div>
                    <div class="col-lg-4" style="margin-top: 30px">
                       
						  <button type="submit" class="btn btn-success" data-toggle="modal" data-target="#myModal">Add Generic Code</button>
						
                    </div>
                    <div class="col-lg-3" style="margin-top: 30px">
                        <form class="form-inline">
						  <div class="form-group">
						    <input type="text" class="form-control" id="exampleInputName2" placeholder="Search..">
						  </div>
						  <button type="submit" class="btn btn-default"><i class="fa fa-search" aria-hidden="true"></i></button>
						</form>
                    </div>
                </div>
                <!-- /.row -->
		
			 <!-- Page Heading Row -->
                <div class="row">
                    <div class="col-lg-12">
                        <ol class="breadcrumb">
                            <li class="active">
                                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; 
                                <i class="fa fa-hand-o-right" aria-hidden="true"></i>	[T30004]
                            </li>
                        </ol>
                    </div>
                </div>
              <!-- //Page Heading Row -->
              
              
              
              <!-- Modal for save generic name -->
				<div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog">
				
				    <!-- Modal content-->
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <center><h4 class="modal-title">Add Generic Code</h4></center>
				      </div>
				      <div class="modal-body">
							<form action="saveGenericCode" method="post">
							  <div class="form-group">
							    <label for="exampleInputEmail1">Generic </label>
							    <input type="text" name="TLang2Nam" class="form-control" placeholder="" required="required">
							  </div>
							  <center>
							  <div class="checkbox">
							    <label>
							      <input type="checkbox" name="TActiveFlag" value="1" checked="checked"> active
							    </label>
							  </div>
							   </center>
							  <center>
								  <button type="submit" class="btn btn-success">Save</button>
								  <button type="reset" class="btn btn-danger">Reset</button>
							  </center>
							</form>
				        
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				      </div>
				    </div>
				
				  </div>
				</div>
              <!-- // Modal for save generic name -->
              
              
              <!-- generic code showing table row -->
              <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-info">
                        
                        	<table class="table table-condensed">
                        		<thead>
                       			<tr class="success">
                       			  <td><b>GENERIC CODE</b></td>
								  <td><b>GENERIC NAME</b></td>
								  <td><b>ACTIVE FLAG</b></td>
                       			</tr>
                        		</thead>
                        		
                        	<!-- show database table in table row -->
								<c:forEach var="t30004" items="${t30004}">
					            <tr class="info">
					                <td>${t30004.getTGenCode()}</td>
					               	<td contenteditable='true'>${t30004.getTLang2Nam()}</td>
					               	<td>
									<c:choose>
									  <c:when test="${t30004.getTActiveFlag() eq 1}">
										 <input type="checkbox" name="TActiveFlag" value="1" checked="checked"> active
									  </c:when>
									  
									  <c:otherwise>
										 <input type="checkbox" name="TActiveFlag" value="1"> active
									  </c:otherwise>
									</c:choose>
					               	</td>
					            </tr>
					            </c:forEach>
					        <!-- //show database table in table row -->
					        
							</table>
                            
                        </div>
                    </div>
              </div>
              <!-- // generic code showing table -->
              
	 	</div>
	    <!-- //container-fluid -->
	
	</div>
	<!-- //page-wrapper -->










<jsp:include page="layout/footer.jsp" />