#!/bin/sh
# --add-host="host:ip"      : Add a line to /etc/hosts (host:IP)
# --network=xxx
# -e XXX_HOST=xxx  ->  ${XXX_HOST} 
#docker run -e SERVICE_HOST=service --add-host="service:172.18.0.3" -d -p 9080:9080 -p 9443:9443 --rm --name=app wlp:app
docker run --network=my-net -e SERVICE_HOST=service -d -p 9080:9080 -p 9443:9443 --rm --name=app wlp:app

