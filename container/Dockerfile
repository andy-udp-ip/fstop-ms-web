FROM websphere-liberty
# install websphere liberty admin console
ARG REPOSITORIES_PROPERTIES=""
ENV LICENSE accept
RUN if [ ! -z $REPOSITORIES_PROPERTIES ]; then mkdir /opt/ibm/wlp/etc/ \
  && echo $REPOSITORIES_PROPERTIES > /opt/ibm/wlp/etc/repositories.properties; fi \
  && installUtility install --acceptLicense \
    adminCenter-1.0 \
  && if [ ! -z $REPOSITORIES_PROPERTIES ]; then rm /opt/ibm/wlp/etc/repositories.properties; fi \
  && rm -rf /output/workarea /output/logs
# deploy application  
COPY server.xml /config/server.xml
RUN sh -c 'mkdir -p /config/configDropins/overrides'
COPY custom-cfg.xml /config/configDropins/overrides/
ADD *.war /config/dropins/
#EXPOSE 80 9080 9448 9443 9060