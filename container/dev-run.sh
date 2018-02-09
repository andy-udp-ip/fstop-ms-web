#!/bin/sh
docker run --network=my-net -e SERVICE_HOST=service -d -p 8001:9080 -p 8002:9443 --rm --name=app -v /home/andy/work/docker/temp/fstop-ms-web.war:/config/dropins/fstop-ms-web.war websphere-liberty

