# talk

根据书名或文章、文档自定义属于自己的个人单词库。

## 缘起

之前使用过差不多近3个月的扇贝来背单词，发觉可选的词库很少，而且没有专门针对计算机的书本来组织的词库，比如《Core Java》，后来发觉还是有一些类似的小整合，比如《C programming language》，但是尝试一段时间后，发现里面的单词不符合自己预期，一大部分是完全没必要的。

主要是我背单词的目的，其实主要是勉强看懂英语的计算机相关书本，比如《Core Java》，对于书中的人名，地名一类的称呼或简称，完全没有必要知道。所以萌生了这个想法，还不如自己编写一套词库，这套词库，就根据自己日常的学习中，把不认识的单词，经常需要查阅的单词整理，随时拿出来阅读。

## 过程

做这件事的过程。

### 1. 2018-03-18，集成百度通用翻译

看了一下，开放的翻译平台还真不少。原本是选择谷歌翻译的，似乎国内使用不是很方便，就选择了有一定免费额度的百度通用翻译，但是无法使用读音了。等差不多，如果需要音标，读音一类的时候，可能去选择有道的付费翻译平台。百度翻译平台通用翻译接口提供的demo写的还不错，修改一下就可以直接使用了。

### 2. 2018-03-19 设计图书和单词模型

添加图书和单词模型，单词按图书编号，各占一张表。

### 3. 2018-03-20 接入有道翻译

有道翻译提供的信息更齐全，包含音标和释义等，但是需要收费。将请求管理统一修改为Apache的HttpClient客户端管理。
