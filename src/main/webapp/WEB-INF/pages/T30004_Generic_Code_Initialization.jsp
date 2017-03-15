<jsp:include page="layout/header.jsp" />
<jsp:include page="layout/topNav.jsp" />



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
							      <input type="checkbox" name="TActiveFlag" value="1"> active
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
              
              
              <!-- generic code save row -->
              <div class="row">
                    <div class="col-lg-12">
                        <div class="alert alert-info">
                        
                        	<!-- save row -->
                            <div class="row">
                            	<div class="col-lg-6">
                            		
                            	
									
									
                            		
                            	</div>
                            </div>
                            <!-- //save row -->
                            
                        </div>
                    </div>
              </div>
              <!-- // generic code save row -->
              
	 	</div>
	    <!-- //container-fluid -->
	
	</div>
	<!-- //page-wrapper -->










<jsp:include page="layout/footer.jsp" />