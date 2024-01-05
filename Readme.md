redis-cli -h garashis.redis.cache.windows.net -p 6379 -a W.....Us=
KEYS *
GET "user::1"
DEL "user::1"


* zookeeper-server-start ../config/zookeeper.properties
* kafka-server-start ../config/server.properties
* kafka-topics.sh --list --bootstrap-server localhost:9092
* kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
* kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092