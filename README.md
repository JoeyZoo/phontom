# phontom_video
phontom是一个户外运动视频社区，用户可在社区内围观户外达人发布的优质作品，也可以主动分享自己创作的户外视频。

笔者本人非常喜欢户外运动，但户外运动目前还是一个相对小众的圈子，在主流视频平台（如bilibili，youku等）虽然也有许多优质的户外作品发布，但是因为平台业务分散或者平台主题属性较强（如Bilibili二次元文化），导致户外用户群体分散流落在各个平台，哪怕优质的视频作品点击量却不尽人意，归根结底，好作品之所以被淹没，是因为很难触及有相同兴趣爱好的个体。

笔者希望通过phontom户外运动社区，能将那些热爱户外运动的驴友们聚集起来，让优质的户外作品能直接触达目标用户群体，让户外运动爱好者们有自己的家，不再寄人篱下😄。


项目技术栈：

phontom是一个前后端分离的微服务项目

前端使用nuxt.js框架搭建，部署在node.js上，采用SSR服务端渲染

nginx作反向代理,请求转发

后端使用springboot脚手架搭建，nacos作为注册中心，微服务之间通过rpc调用

数据库使用mysql 
