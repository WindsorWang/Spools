#!/bin/bash
clear
####cd /opt/appl/h2finance/timer/bin
cd /opt/appl/prod/mgold/timer/bin
nohup java -Xms2048M -Xmx2048M -XX:PermSize=64M -XX:MaxPermSize=512m -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=7 -XX:GCTimeRatio=19  -XX:+DisableExplicitGC -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+CMSPermGenSweepingEnabled -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0 -XX:+CMSClassUnloadingEnabled  -XX:-CMSParallelRemarkEnabled -XX:CMSInitiatingOccupancyFraction=80 -XX:SoftRefLRUPolicyMSPerMB=0 -cp ../lib/*.jar: -jar ../lib/timer.jar > ../logs/nohup.out & 
echo $! > h2finance-timer.pid
