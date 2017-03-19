<%-- 
    Document   : urlTable
    Created on : Mar 12, 2017, 9:25:05 AM
    Author     : abdalrahman.sharawy
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<table class="table table-hover">
  <thead>
    <tr>
      <th>#</th>
      <th>Original URL</th>
      <th>Shorted Url</th>
      <th>Visitors</th>
    </tr>
  </thead>
 
  <tbody>
      
      <tr ng-repeat="urlModel in shortedUrls">
      <th scope="row">{{urlModel.id}}</th>
      <td>{{urlModel.url}}</td>
      <td><a href="{{urlModel.shortCode}}">{{getContextPath()}}{{urlModel.shortCode}}</a></td>
      <td>{{urlModel.visitorsNumber}}</td>
    </tr>
   
  </tbody>
</table>