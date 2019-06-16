## 1 获取当前最新区块

method：GET  
url: /block/getRecentBlocks

response:
```json
[
    {
        "blockhash": "00000000000002160e501d80be1463a6210eccf8a400ebb55fb4cb4549947b48",
        "height": 1543589,
        "time": "2019-06-15T13:03:47.232+0000",
        "txsize": 35,
        "size": 12805,
        "chainwork":"00000000000000000000000000000000000000000000011b0ce0c84102692201"
    },
    {
        "blockhash": "00000000000002940ade0c2b454b0c3b8b9606725c47ee6fffcdd68c5e9e435c",
        "height": 1543644,
        "time": "2019-06-15T13:03:47.232+0000",
        "txsize": 8,
        "size": 2133,
        "chainwork":"00000000000000000000000000000000000000000000011b0ce0c84102692201"
    }
]
```

| ResponseField |  Type   |        Description         |
|:-------------:|:-------:|:--------------------------:|
|   blockhash   | String  |          区块hash          |
|    height     | Integer |          区块高度          |
|     time      |  Date   |          出块时间          |
|    txsize     | Integer |          交易数量          |
|     size      | Integer |          区块大小          |
|   chainwork   | String  | 生成到此块的链所需的哈希数 |

  
  
## 2 根据区块hash获取区块详情

method：GET  
url: /block/getByBlockhash/{blockhash}

response:
```json
{
    "blockhash": "0000000000000061aa4efcb9e905c9a41c6c7dc771a8c1a7ec1c45285e851330",
    "confirmations": 1,
    "strippedsize": 18186,
    "size": 36317,
    "weight": 90875,
    "height": 1543652,
    "version": 536928256,
    "merkleroot": "e74f9233b4c8ca860710ed7a3b67797b727efec1e324933dbc903a7ecbe488f5",
    "time": "2019-06-15T14:24:03.941+0000",
    "receivedTime": "2019-06-15T14:24:03.941+0000",
    "relayedBy": "AntPool",
    "nonce": 214911287,
    "difficulty": 4194304,
    "chainwork": "00000000000000000000000000000000000000000000011b1c60d7c211ea3182",
    "txsize": 111,
    "nextBlock": "00000000000000000000000000000000000000000000011b1c60d7c211ea3182",
    "prevBlock": "00000000000000067aac0c037e978fd5ddc0c16560ea541fa09a92479ec7f184",
    "outputTotal": 4465.02389308,
    "fees": 0.63557721,
    "blockReward": 12.5,
    "transactionList": [
        "4267ab3453217020610c57497408524123e65538108425f476a01520eb083dfb",
        "4936e12a4c213021d29cb7bfebe604b60b4c2e4ec416d23f25a1ae609226bfc3",
        "9f12c5562afce30e331e783452994d23e8db40126539fc00631f88a584943cf4",
        "8dbf870755ec560a004364e2c8823b331b66e1d5f682be02a7fa5967359d45bf",
        "9283db04e55b6db4ef174fca723b5a35d7725fe60d169b59fb82bb8ae72aac82",
        "9c10e90529d9a3882874184a5ba6e66b60d85062a1414d3e648baa197d490889",
        "563785a73a18d36a05cef8b855a6f58c91d28907de8c3c58cd818dbdecb51c01",
        "6e74634e3a582c671ed50da17c92b5b183c5d6c078d4543dc669b8a59041c408"
    ]
}
```

|  ResponseField  |  Type   |        Description         |
|:---------------:|:-------:|:--------------------------:|
|    blockhash    | String  |          区块hash          |
|  confirmations  | Integer |         交易确认数         |
|  strippedsize   | Integer |          文件大小          |
|      size       | Integer |          区块大小          |
|     weight      | Integer |          区块重量          |
|     height      | Integer |          区块高度          |
|     version     | Integer |      区块头数据的版本      |
|   merkleRoot    | String  |          梅尔克树          |
|      time       |  Long   |          出块时间          |
|  receivedTime   |  Long   |          接收时间          |
|    relayedBy    | String  |            矿池            |
|      nonce      | Integer |        工作量计算数        |
|    prevBlcok    | String  |         前一个区块         |
|    nextBlock    | String  |         后一个区块         |
|    chainwork    | String  | 生成到此块的链所需的哈希数 |
|     txSize      |  Short  |          交易数量          |
|   outputTotal   | Double  |           总输出           |
|      fees       | Double  |          交易费用          |
|   blockReward   | Double  |          区块奖励          |
|   difficulty    | Double  |          难度系数          |
| transactionList |  List  |         交易的列表         |

  

## 3 根据区块高度获取区块详情

method：GET  
url: /block/getByHeight/{height}

response:
```json
{
    "blockhash": "0000000000000061aa4efcb9e905c9a41c6c7dc771a8c1a7ec1c45285e851330",
    "confirmations": 1,
    "strippedsize": 18186,
    "size": 36317,
    "weight": 90875,
    "height": 1543652,
    "version": 536928256,
    "merkleroot": "e74f9233b4c8ca860710ed7a3b67797b727efec1e324933dbc903a7ecbe488f5",
    "time": "2019-06-15T14:24:03.941+0000",
    "receivedTime": "2019-06-15T14:24:03.941+0000",
    "relayedBy": "AntPool",
    "nonce": 214911287,
    "difficulty": 4194304,
    "chainwork": "00000000000000000000000000000000000000000000011b1c60d7c211ea3182",
    "txsize": 111,
    "nextBlock": "00000000000000000000000000000000000000000000011b1c60d7c211ea3182",
    "prevBlock": "00000000000000067aac0c037e978fd5ddc0c16560ea541fa09a92479ec7f184",
    "outputTotal": 4465.02389308,
    "fees": 0.63557721,
    "blockReward": 12.5,
    "transactionList": [
        "4267ab3453217020610c57497408524123e65538108425f476a01520eb083dfb",
        "4936e12a4c213021d29cb7bfebe604b60b4c2e4ec416d23f25a1ae609226bfc3",
        "9f12c5562afce30e331e783452994d23e8db40126539fc00631f88a584943cf4",
        "8dbf870755ec560a004364e2c8823b331b66e1d5f682be02a7fa5967359d45bf",
        "9283db04e55b6db4ef174fca723b5a35d7725fe60d169b59fb82bb8ae72aac82",
        "9c10e90529d9a3882874184a5ba6e66b60d85062a1414d3e648baa197d490889",
        "563785a73a18d36a05cef8b855a6f58c91d28907de8c3c58cd818dbdecb51c01",
        "6e74634e3a582c671ed50da17c92b5b183c5d6c078d4543dc669b8a59041c408"
    ]
}
```
|  ResponseField  |  Type   |        Description         |
|:---------------:|:-------:|:--------------------------:|
|    blockhash    | String  |          区块hash          |
|  confirmations  | Integer |         交易确认数         |
|  strippedsize   | Integer |          文件大小          |
|      size       | Integer |          区块大小          |
|     weight      | Integer |          区块重量          |
|     height      | Integer |          区块高度          |
|     version     | Integer |      区块头数据的版本      |
|   merkleRoot    | String  |          梅尔克树          |
|      time       |  Long   |          出块时间          |
|  receivedTime   |  Long   |          接收时间          |
|    relayedBy    | String  |            矿池            |
|      nonce      | Integer |        工作量计算数        |
|    prevBlcok    | String  |         前一个区块         |
|    nextBlock    | String  |         后一个区块         |
|    chainwork    | String  | 生成到此块的链所需的哈希数 |
|     txSize      |  Short  |          交易数量          |
|   outputTotal   | Double  |           总输出           |
|      fees       | Double  |          交易费用          |
|   blockReward   | Double  |          区块奖励          |
|   difficulty    | Double  |          难度系数          |
| transactionList |  List  |         交易的列表         |