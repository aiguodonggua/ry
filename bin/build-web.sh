#!/usr/bin/sh
cd /home/workspace/ShengTangManage/ruoyi-ui
git pull origin master
yarn
yarn build:prod
rm -rf /home/web/manage.shengtangdiet.com/dist
cp -rf ./dist /home/web/manage.shengtangdiet.com/