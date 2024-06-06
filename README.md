# 20240606 复习两年前的代码有感
## Spring Security
我看这次代码的原因是想搭建一个spring Security的demo，因为这个项目成功集成了spring Security。
## 框架
这次搭的框架也有些问题，主要是对Spirng Security 和 SSO的理解有偏差。通过对比ruoyi、pig之后，就发现自己搭的有问题，
1. mapper 和 service 不应该分开
2. pc-api 和 oauth2-resource是一样的，不应该分开，并且不应该做成服务，而应该做成common
3. sso-api 直接叫sso就行，因为这个就是sso的服务
## 概念
1. Spring Security 是一个权限认证的框架，说白了就是掌管登录的，不要和SSO混淆了。SSO可以使用Spring Security来实现。
2. 若依就没有使用Spring Security来登录，就是自己实现了一套登录。
3. 项目可以不用SSO，但是一般都有登录
4. oauth2 有四种认证方式，授权码模式、密码模式、客户端模式、简化模式。授权码模式主要是第三方系统接入公司的时候用，它比较安全，
但是稍微麻烦一些，不建议上来就拿这个方式来练手。建议用密码模式，这种模式和我们平时用户名密码登录的方式类似，比较好理解。公司内部的服务登录
直接用密码模式就行。这四种方式可以参考：https://juejin.cn/post/6949929792502235149
5. 模仿其他框架，自己集成了spring Security https://github.com/zsdnishishui/lianxi.git
# 教训
对概念的理解一定要准确，不然自己搭的框架就会乱七八糟。但是怎么把概念理解准确呢，还是要自己多思考，多实践没有捷径可走。