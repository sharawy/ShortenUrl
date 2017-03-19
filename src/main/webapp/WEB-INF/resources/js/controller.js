'use strict';

/* Controllers */

angular
        .module('shortenUrlApp')
        .controller('mainController', MainController);

MainController.$inject = ['$scope', 'urlService'];

function MainController($scope, urlService) {

    $scope.urlModel = null;
    $scope.errors = [];
    $scope.shortedUrls = [];
   $scope.getContextPath = function() {
        return window.location;
    }
    $scope.getShortedUrls = function() {
        urlService.getShortedUrls().then(function(response) {
            console.log(response.data.result);
            $scope.shortedUrls = response.data.result;
        });
    }
    $scope.generateShortUrl = function() {

        return urlService.generateShortUrl($scope.urlModel)
                .then(function(response) {
                    console.log(response.data);
                    if (response.data.errors) {
                        $scope.errors = response.data.errors;
                        return;
                    }
                    console.log(response.data.result.shortCode);
                    $scope.getShortedUrls();


                });
    }
    $scope.getShortedUrls();
}