npm i -D @graphql-hive/cli 

for subgraph:
- token : "fec0a5d980999def30b468be739e5f85"
- autoSchemaFile: join(process.cwd(), 'src/schema.gql')
- Olusan graphql de @tag directive i silinmeli
- npx hive schema:publish --registry.accessToken fec0a5d980999def30b468be739e5f85  --service="policy" --url="http://localhost:3010/graphql" --author "Me" --commit "register" src/schema.gql  

for supergraph:

|| in win:
- Invoke-WebRequest -Uri 'https://cdn.graphql-hive.com/artifacts/v1/c3c7c27f-9c30-4deb-a88b-351c64ceb5e6/sdl' -Headers @{ 'X-Hive-CDN-Key' = 'hv2ODE5MzQ1M2ItOTQwNS00Yzg1LTk1ODEtNmNlYmEwYWM5Zjk2OjM0NGIwNWY4Mzk4MmM3ZDg2MDQ3YTc2MTYzNTc2MTkwYTZmNTkw' }   
- Invoke-WebRequest -Uri 'https://cdn.graphql-hive.com/artifacts/v1/c3c7c27f-9c30-4deb-a88b-351c64ceb5e6/supergraph' -Headers @{ 'X-Hive-CDN-Key' = 'hv2ODE5MzQ1M2ItOTQwNS00Yzg1LTk1ODEtNmNlYmEwYWM5Zjk2OjM0NGIwNWY4Mzk4MmM3ZDg2MDQ3YTc2MTYzNTc2MTkwYTZmNTkw' }

|| CURL ile
- curl -L -H 'X-Hive-CDN-Key:hv2ODE5MzQ1M2ItOTQwNS00Yzg1LTk1ODEtNmNlYmEwYWM5Zjk2OjM0NGIwNWY4Mzk4MmM3ZDg2MDQ3YTc2MTYzNTc2MTkwYTZmNTkw' https://cdn.graphql-hive.com/artifacts/v1/c3c7c27f-9c30-4deb-a88b-351c64ceb5e6/supergraph
- curl -L -H 'X-Hive-CDN-Key:hv2ODE5MzQ1M2ItOTQwNS00Yzg1LTk1ODEtNmNlYmEwYWM5Zjk2OjM0NGIwNWY4Mzk4MmM3ZDg2MDQ3YTc2MTYzNTc2MTkwYTZmNTkw' https://cdn.graphql-hive.com/artifacts/v1/c3c7c27f-9c30-4deb-a88b-351c64ceb5e6/sdl

- supergraphSdl: createSupergraphManager({
    endpoint: "https://cdn.graphql-hive.com/artifacts/v1/c3c7c27f-9c30-4deb-a88b-351c64ceb5e6",
    key: "hv2ODE5MzQ1M2ItOTQwNS00Yzg1LTk1ODEtNmNlYmEwYWM5Zjk2OjM0NGIwNWY4Mzk4MmM3ZDg2MDQ3YTc2MTYzNTc2MTkwYTZmNTkw",
    pollIntervalInMs: 15_000
  })

