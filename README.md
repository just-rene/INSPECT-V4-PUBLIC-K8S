# DEPRECATED SEE https://github.com/just-rene/INSPECT-IA-PUBLIC

# INSPECT 
INSPECT is a sentiment and NER extraction tool!

## New Features 4.0:
Kubernetes load balanced microservices


## Features

#### STOCK SENTIMENT CORRELATION (NEW)
computes correlation between sentiment and stock data
![stock_sentiment_correlation](./Screenshots/stock_sentiment_correlation.PNG)


#### EMOTION FILTER
filter article by emotions
![emotion_filter](./Screenshots/emotion_filter.png)


#### SENTIMENT BY DAY
track the overall sentiment by day
![sentiment_by](./Screenshots/sentiment_by_day.png)

#### NER
extract important locations, persons, organisations and misc 
![ner](./Screenshots/NER.png)

#### FOLLOW TOPIC
cluster multiple topics to one umbrella term and track the sentiment over time
![sentiment_by](./Screenshots/followed_topic.PNG)
![sentiment_by](./Screenshots/followed_topic_2.PNG)


## Setup

## Authentication Ingress
Here are all steps for creating a authentication for ingress, if required:
https://kubernetes.github.io/ingress-nginx/examples/auth/basic/


## StatefulSet MongoDB
Here are all steps for creating a StatefulSet with mongoDB, if required:
https://www.mongodb.com/developer/products/mongodb/mongodb-with-kubernetes/


#### APIs: 
Huggingface account (API-key), [Huggingface](https://huggingface.co/) <img src="./Screenshots/huggingface.svg" width="20">  
polygon account (API-key)  [Polygon](https://polygon.io/)    <img src="./Screenshots/polygon.png" width="20">

### remarks
1) all webscrapper have been removed for legal reasons 
1) inputs are not validated

