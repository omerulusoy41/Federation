package com.ofu.federation.configuration;

import com.apollographql.federation.graphqljava.Federation;

import com.apollographql.federation.graphqljava.tracing.FederatedTracingInstrumentation;
import com.ofu.federation.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfiguration {
    @Autowired
    private BookService bookService;

    @Bean
    public FederatedTracingInstrumentation federatedTracingInstrumentation() {
        return new FederatedTracingInstrumentation();
    }

    @Bean
    public GraphQlSourceBuilderCustomizer federationTransform() {
        return builder -> builder.schemaFactory((registry, wiring)->
                Federation.transform(registry, wiring)
                        .fetchEntities(env -> null)
                        .resolveEntityType(env -> null)
                        .build()
        );
    }
}
