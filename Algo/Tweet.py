# import numpy as np
# import matplotlib as mp

from newsapi import NewsAPI

# from __future__ import absolute_import
# from __future__ import division
# from __future__ import print_function

key = '96af62a035db45bda517a9ca62a25ac3'
params = {}
api = NewsAPI(key)
sources = api.sources(params)
articles = api.articles(sources[0]['id'], params)
import sys, csv, json

reload(sys)
sys.setdefaultencoding('utf8')

import requests

class APIKeyException(Exception):
    def __init__(self, message): self.message = message


class InvalidQueryException(Exception):

    #def __init__(self): self.message = message
    def __init__(self, message): self.message = message


class ArchiveAPI(object):
    def __init__(self, key=None):
        self.key = key
        self.root = 'http://api.nytimes.com/svc/archive/v1/{}/{}.json?api-key={}'
        if not self.key:

            #nyt_dev_page = 'Web site'
            #exception_str = 'Error'


            nyt_dev_page = 'http://developer.nytimes.com/docs/reference/keys'
            exception_str = 'API required.'
            raise NoAPIKeyException(exception_str.format(nyt_dev_page))

    def query(self, year=None, month=None, key=None, ):
        if not key: key = self.key
        if (year < 1882) or not (0 < month < 13):



            raise InvalidQueryException('Invalid query')
        url = self.root.format(year, month, key)
        r = requests.get(url)
        return r.json()

    # with slim.arg_scope([slim.conv2d, slim.fully_connected],
    #                     weights_regularizer=slim.l2_regularizer(weight_decay)):



    #     with slim.arg_scope(
    #         [slim.conv2d],
    #         weights_initializer=slim.variance_scaling_initializer(),
    #         activation_fn=tf.nn.relu,
    #         normalizer_fn=normalizer_fn,
    #         normalizer_params=normalizer_params) as sc:


api = ArchiveAPI('0ba6dc04a8cb44e0a890c00df88c393a')

#years = [2016, 2015]
#months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
years = [2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007]
months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]

for year in years:
    for month in months:

        mydict = api.query(year, month)
        file_str = '/Users/Arun/Documents/Stock_predictions/data/' + str(year) + '-' + '{:02}'.format(
            month) + '.json'
        with open(file_str, 'w') as fout:

            json.dump(mydict, fout)
        fout.close()


