'use strict';

/* Services */

angular
    .module('shortenUrlApp')
    .factory('urlService', urlService);

urlService.$inject = ['$http'];

function urlService($http) {
    return {
        generateShortUrl: generateShortUrl,
        getShortedUrls : getShortedUrls
    };
    function getShortedUrls(){
        return $http.get('/shortenUrl/getShortedUrls')
                .then(getShortedUrlsComplete)
                .catch(getShortedUrlsFailed);
        function getShortedUrlsComplete(response) {
            return response;
        }

        function getShortedUrlsFailed(error) {
            console.log(error.data);
        }
    }
    function generateShortUrl(urlModel) {
        return $http.post('/shortenUrl/shortUrl',urlModel)
            .then(generateShortUrlComplete)
            .catch(generateShortUrlFailed);

        function generateShortUrlComplete(response) {
            return response;
        }

        function generateShortUrlFailed(error) {
            console.log(error.data);
        }
    }
}