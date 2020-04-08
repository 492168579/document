cd /var/img
tar czvf 安装图片-$(date +%Y%m%d).tar assemble
mv 安装图片-$(date +%Y%m%d).tar /var/img/picture-bak
tar czvf 问题工单附件-$(date +%Y%m%d).tar attachment
mv 问题工单附件-$(date +%Y%m%d).tar /var/img/picture-bak
cd /var
tar czvf 导入模板-$(date +%Y%m%d).tar template
mv 导入模板-$(date +%Y%m%d).tar /var/img/picture-bak
