#!/bin/bash

####cd /opt/appl/h2finance/timer/bin
cd /opt/appl/prod/mgold/timer/bin
echo "killing: `cat h2finance-timer.pid`"
kill -9 `cat h2finance-timer.pid`
rm -rf h2finance-timer.pid
