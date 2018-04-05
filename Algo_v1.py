# import numpy as np
# import matplotlib as mp
#
#
# X = np.array([ [0,0,1],[0,1,1],[1,0,1],[1,1,1] ])
# y = np.array([[0,1,1,0]]).T
# syn0 = 2*np.random.random((3,4)) - 1
# syn1 = 2*np.random.random((4,1)) - 1
# for j in xrange(60000):
#     l1 = 1/(1+np.exp(-(np.dot(X,syn0))))
#     l2 = 1/(1+np.exp(-(np.dot(l1,syn1))))
#     l2_delta = (y - l2)*(l2*(1-l2))
#     l1_delta = l2_delta.dot(syn1.T) * (l1 * (1-l1))
#     syn1 += l1.T.dot(l2_delta)
#     syn0 += X.T.dot(l1_delta)
# print syn0
# print syn1

# from keras.layers.core import Dense, Activation, Dropout
# from keras.layers.recurrent import LSTM
# from keras.models import Sequential
# import pandas as pd

import csv
import numpy as np
import sklearn.svm as SVR
import matplotlib
matplotlib.use('TkAgg')
import matplotlib.pyplot as plt

dates = []
prices = []


def get_data(fname):
    with open(fname, 'r') as csvfile:
        csvFileReader = csv.reader(csvfile)
        next(csvFileReader)
        for row in csvFileReader:
            dates.append(int(row[0].split('-')[0]))
            prices.append(row[1])
    print(dates)
    print(prices)
    return


def predict_prices(dates, prices, x):
    dates = np.reshape(dates, len(dates), 1)

    svr_lin = SVR(kernel='linear', C=1e3)
    svr_poly = SVR(kernal='poly', C=1e3, degree=2)
    svr_rbf = SVR(kernal='rbf', C=1e3)
    svr_lin.fit(dates, prices)
    svr_poly.fit(dates, prices)
    svr_rbf.fit(dates, prices)

    plt.scatter(dates, prices, color='black', label='Data')
    plt.plot(dates, svr_rbf.predict(dates), color='red', label='RBF Model')
    plt.plot(dates, svr_poly.predict(dates), color='green', label='Polynomial Model')
    plt.plot(dates, svr_lin.predict(dates), color='blue', label='Linear Model')

    plt.xlabel('Date')
    plt.ylabel('Price')
    plt.title('Support Vector Regression')
    plt.legend()
    plt.show()

    return svr_rbf.predict(x)[0], svr_lin.predict(x)[0], svr_poly.predict(x)[0]


get_data('/Users/arun/Documents/ProfProject/AAPL_2014_2018.csv')

pred_prices = predict_prices(dates, prices, 2019)

print pred_prices
