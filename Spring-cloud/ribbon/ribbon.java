----------------------------
ribbon						|
----------------------------
	# Spring Cloud Ribbon 是基于Netflix Ribbon实现的一套'客户端,负载均衡'工具
	# Ribbon是netflix发布的开源项目,主要提供客户端的软件负载均衡算法
	# LB(Load Balance)在微服务或者分布式集群中经常用的一种应用
	# 常见的负载均衡Nginx,LVS,硬件F5
	
	# 负载均衡的类型
		* 硬件LB
			* F5之类的,买不起
		* 进程内LB
			* 把LB逻辑集成到消费方,消费方从注册中心获取服务地址,再从地址中选择一个进行调用
	
	# ribbon在工作时分为两步
		1,先选择EurekaServer,会选择同一区域内负载较少的EurekaServer
		2,根据用户指定的策略,从Server取到服务提供者(多个)的地址信息中获取一个进行远程调用
	
	# ribbon提供了多种策略:轮询,随机,根据响应时间加权

	# 默认算法是-轮询


----------------------------
整合						|
----------------------------
	# 坐标
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-ribbon</artifactId>
			<version>1.4.4.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
			<version>1.4.4.RELEASE</version>
		</dependency>
	
	# 开启负载均衡
		@Configuration
		public class RestTemplateConfig{

			@Bean
			@LoadBalance
			public RestTemplate restTemplate(){
				return new RestTemplate();
			}
		}

		* 给 RestTemplate 注册Ioc时,添加 @LoadBalance 注解
		

		

	