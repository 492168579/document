cd /var/img
tar czvf ��װͼƬ-$(date +%Y%m%d).tar assemble
mv ��װͼƬ-$(date +%Y%m%d).tar /var/img/picture-bak
tar czvf ���⹤������-$(date +%Y%m%d).tar attachment
mv ���⹤������-$(date +%Y%m%d).tar /var/img/picture-bak
cd /var
tar czvf ����ģ��-$(date +%Y%m%d).tar template
mv ����ģ��-$(date +%Y%m%d).tar /var/img/picture-bak
