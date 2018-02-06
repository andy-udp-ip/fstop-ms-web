websphere liberty 的 server.xml 用來進行一般性的設定

在 websphere liberty 的 usr/servers/server_name/configDropins/overrides 中放入 custom-cfg.xml
設定  <webContainer invokeFlushAfterService="false"/>
以避免 spring mvc 顯示 jsp 異常


