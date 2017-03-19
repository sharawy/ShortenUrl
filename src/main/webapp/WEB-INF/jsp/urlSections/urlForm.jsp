<%-- 
    Document   : urlForm
    Created on : Mar 12, 2017, 9:24:42 AM
    Author     : abdalrahman.sharawy
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<div class="container text-center">
            <p class="label-danger" ng-repeat="error in errors">{{error.defaultMessage}}</p>
        </div>
   <!-- Form Area -->
    <div >
        <!-- Form -->
     
            <!-- Left Inputs -->
            <div class="col-xs-12 wow animated slideInLeft" data-wow-delay=".5s">
                <!-- Url -->
                <input ng-model="urlModel.url" type="text" name="url" id="url" required="required" class="form" placeholder="url" />
        
            </div><!-- End Left Inputs -->
         
           
            <!-- Bottom Submit -->
            <div class="relative fullwidth col-xs-12">
                <!-- Send Button -->
                <button type="button" id="submit" name="submit" class="form-btn semibold" ng-click="generateShortUrl()">Short Url</button> 
            </div><!-- End Bottom Submit -->
            <!-- Clear -->
            <div class="clear"></div>
    



    </div><!-- End Url Form Area -->