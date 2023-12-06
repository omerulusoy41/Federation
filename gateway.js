const { ApolloServer } = require("apollo-server");
const { ApolloGateway, IntrospectAndCompose } = require("@apollo/gateway");

const gateway = new ApolloGateway({
    supergraphSdl: new IntrospectAndCompose({
      subgraphs: [
        {
          name: "book",
          url: "http://localhost:8080/graphql",
        },
        {
          name: "accounts",
          url: "http://localhost:4001/graphql",
        },
        {
          name: "accounts",
          url: "http://localhost:4002/graphql",
        },
        {
          name: "inventory",
          url: "http://localhost:4004/graphql",
        },
        {
          name: "products",
          url: "http://localhost:4003/graphql",
        },
      ],

      pollIntervalInMs: 15000, // That will automatically poll the services again in each interval
    }),
    // Experimental: Enabling this enables the query plan view in Playground.
    __exposeQueryPlanExperimental: false,
});

(async () => {
    const server = new ApolloServer({
        gateway,

        // Apollo Graph Manager (previously known as Apollo Engine)
        // When enabled and an `ENGINE_API_KEY` is set in the environment,
        // provides metrics, schema management and trace reporting.
        engine: false,

        // Subscriptions are unsupported but planned for a future Gateway version.
        subscriptions: false,
    });

    server.listen().then(({ url }) => {
        console.log(`🚀 Server ready at ${url}`);
    });
})();