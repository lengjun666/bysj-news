~~~nginx
server {
        listen 8010;
        server_name localhost;
        location / {

        }
        location /img/ {
            root /home/upload/img/;
            # 访问url localhost:8010/upload/img/filename
        }
    }
~~~