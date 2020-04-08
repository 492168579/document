#!/bin/bash
if [ -f ~/.bash_profile ];
then
  . ~/.bash_profile
fi
exp ammeter/Ammeter_2018  file=/home/oracle/bak-oracle/ammeter-$(date +%Y%m%d).dmp
exp ammeter_install/Ammeter_2018  file=/home/oracle/bak-oracle/ammeter_install-$(date +%Y%m%d).dmp
exp ammeter_mobile/Ammeter_2018  file=/home/oracle/bak-oracle/ammeter_mobile-$(date +%Y%m%d).dmp
exp ammeter_mobile_znyp/Ammeter_2018  file=/home/oracle/bak-oracle/ammeter_mobile_znyp-$(date +%Y%m%d).dmp

