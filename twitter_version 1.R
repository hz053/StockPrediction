#Initial work has been done as it can be seen.
#Research for further improving the classification part and the visualisation part is being done.
#Word Uploaded date: 6/04/2018

#Load the Libraries required

library(twitteR)
library(syuzhet)
library(rtweet)
library(RCurl)
library(base64enc)
library(qdapRegex)
library(stringr)
library(stringi)
library(lubridate)
library(dplyr)
library(wordcloud)
library(plotly)
library(tm)

#Twitter Consumer Key
consumer_key<-"zp6ngH8hU3HskSSfKqpmDbclX"
#Twitter Consumer Secret
consumer_secret<-"QBCZQaS4BRGMfc53OnzPgbyiYr9w4HBOjfCtDhKoGVVSjku5iF"
#Twitter Access Token
access_token<-"975972344459026433-qp7aazzfDqEYR8G6SV6K2if4xOeVf81"
#Twitter Access Token Secret
access_token_secret<-"uywsrJhMgXkwEnMo6Vhrfp8EUDIudKBxoU7iRQJWL5kD0"
#Create Twitter Connection
setup_twitter_oauth(consumer_key,consumer_secret,access_token,access_token_secret)
1

#Download tweets with Hashtag applestock
Applestock_Tweets<-searchTwitter("apple stock",n=10000)
tweets_df<-twListToDF(Applestock_Tweets)

#Data Preprocessing and cleaning

# Removes RT
tweets_df$text = gsub("(RT|via)((?:\\b\\W*@\\w+)+)", "", tweets_df$text)
#Remove non-ASCII characters
Encoding(tweets_df$text) = "latin1"
tweets_df$text<-iconv(tweets_df$text, "latin1", "ASCII", sub = "")
# Removes @<twitter handle>
tweets_df$text = gsub("@\\w+", "", tweets_df$text)
# Removes punctuations
tweets_df$text = gsub("[[:punct:]]", "", tweets_df$text)
# Removes numbers
tweets_df$text = gsub("[[:digit:]]", "", tweets_df$text)
# remove links http
tweets_df$text = gsub("http\\w+", "", tweets_df$text) 
# Removes html links
tweets_df$text = gsub("http\\w+", "", tweets_df$text)
# Removes unnecessary spaces
tweets_df$text = gsub("[ \t]{2,}", "", tweets_df$text)
tweets_df$text = gsub("^\\s+|\\s+$", "", tweets_df$text)
# Fix for error related to formatting 'utf8towcs'"
tweets_df$text <- str_replace_all(tweets_df$text,"[^[:graph:]]", " ")
#Remove Duplicate data
tweets_df<-tweets_df[!duplicated(tweets_df$text),]
#Remove empty rows where there is no entry in the text column and if the entry is just a single word
tweets_df<-tweets_df[nchar(tweets_df$text)>10,]

#Text to vector format
twit_vec<-as.vector(tweets_df$text)


# function to get various sentiment scores, using the syuzhet package
##This function can further be improved.

scoreSentiment = function(tab)
{
  syuzhet = get_sentiment(tab, method="syuzhet")
  bing = get_sentiment(tab, method="bing")
  afinn = get_sentiment(tab, method="afinn")
  nrc = get_sentiment(tab, method="nrc")
  sentiments <- data.frame(syuzhet, bing, afinn, nrc)
}

# get the sentiment scores for the tweets
twit <- scoreSentiment(twit_vec)

#Get the timestamp
format.str <- "%a %b %d %H:%M:%S %z %Y"
tweets_df$created <- ymd_hms(tweets_df$created)
tweets_df$created <- with_tz(tweets_df$created, "Australia/Sydney")
twit$timestamp<-tweets_df$created


# get the emotions using the NRC dictionary
emotions <- get_nrc_sentiment(twit_vec)
emo_bar = colSums(emotions)
emo_sum = data.frame(count=emo_bar, emotion=names(emo_bar))
emo_sum$emotion = factor(emo_sum$emotion, levels=emo_sum$emotion[order(emo_sum$count, decreasing = TRUE)])


# plot the different sentiments from different methods
##The plots can definitely be improved

plot_ly(twit, x=~timestamp, y=~syuzhet, type="scatter", mode="jitter", name="syuzhet") %>%
  add_trace(y=~bing, mode="lines", name="bing") %>%
  add_trace(y=~afinn, mode="lines", name="afinn") %>%
  add_trace(y=~nrc, mode="lines", name="nrc") %>%
  layout(title="Apple Stock Value Prediction",
         yaxis=list(title="score"), xaxis=list(title="date"))

plot_ly(emo_sum, x=~emotion, y=~count, type="bar", color=~emotion) %>%
  layout(xaxis=list(title=""), showlegend=FALSE,
         title="Distribution of emotion categories for Apple Stock (25 March- 3 April 2017)")


#Create a cumulative file
tweets_df <- tweets_df[, order(names(tweets_df))]
if (file.exists('Tweets.csv')==FALSE) write.csv(tweets_df, file= 'Tweets.csv', row.names=F)
#merge last access with cumulative file and remove duplicates
old_tweets <- read.csv(file='Tweets.csv')
old_tweets <- rbind(old_tweets, tweets_df)
old_tweets <- subset(old_tweets, !duplicated(old_tweets$text))
write.csv(old_tweets, file= 'Tweets.csv', row.names=F)

test_df <- read.csv("Tweets.csv", header=TRUE)





















