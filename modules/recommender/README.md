## Liferay Recommender (TODO - Write Doc)

## Structure

### `recommender-api`  

- `com.liferay.recommender.provider.RecommendationProvider`: Provides the RecommendationProvider generic interface, allowing custom recommendation provider creation.
- `com.liferay.recommender.provider.RecommendationProviderRegistry`: Provides the RecommendationProviderRegistry interface. Class implementing this interface are supposed to track RecommendationProvider services.
- `com.liferay.recommender.service` package: The remote service API.  

### `recommender-engine`
- `com.liferay.recommender.engine.internal.RecomendationProviderRegistryImpl`: Default implementation for `RecommendationProviderRegistry`.  

### `recommender-provider-wiki`  
- `com.liferay.recommender.provider.wiki.internal.WikiPageRecommendationProvider`: Recommendation provider for model `com.liferay.wiki.model.WikiPage`.  

### `recommender-service`
- `com.liferay.recommender.service.impl.RecommenderServiceImpl`: Implementation for the remote recommender service API.
