#!/bin/sh
docker run -d -p 9080:9080 -p 9443:9443 --rm --name=app wlp:custom

