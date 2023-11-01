const { ApolloServer } = require("apollo-server");
const { ApolloGateway, IntrospectAndCompose } = require("@apollo/gateway");
const { createSupergraphManager } = require('@graphql-hive/client')


const supergraphSdl = new createSupergraphManager({
  endpoint: "https://cdn.graphql-hive.com/artifacts/v1/c3c7c27f-9c30-4deb-a88b-351c64ceb5e6",
  key: "hv2ODE5MzQ1M2ItOTQwNS00Yzg1LTk1ODEtNmNlYmEwYWM5Zjk2OjM0NGIwNWY4Mzk4MmM3ZDg2MDQ3YTc2MTYzNTc2MTkwYTZmNTkw",
  pollIntervalInMs: 15_000
})

const gateway = new ApolloGateway({
  supergraphSdl,
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
