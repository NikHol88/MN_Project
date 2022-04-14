import Card from "antd/es/card";
import React, {useEffect, useState} from "react";
import SockJsClient from "react-stomp";
import List from "antd/es/list";
import axios from "axios";

export default function AllConfigs() {
    const SOCKET_URL = 'http://localhost:8080/parser-message';
    const [conf, setConf] = useState([]);

    useEffect(()=> {

        const data = {
            method: 'post',
            url: 'getallconfigs',
            baseURL: 'http://localhost:8080',
        }
        axios(data).then(result => {
           console.log('tset2')
        }).catch(e => {
         /*   setError(true)
            setTimeout(() => { setError(false)}, 5000);
            setLoading(false)*/
        })
    },[])
    return <div>
        <List
            itemLayout="horizontal"
            dataSource={conf}
            renderItem={item => (
                <List.Item>
                    <Card title={item.name} extra={<a href="#">More</a>} style={{ width: "100%" }}>
                        {item.description}
                    </Card>
                </List.Item>
            )}
        />
        <SockJsClient url={SOCKET_URL}
                      topics={['/topic/allconfigs']}
                      onConnect={() => {
                          console.log("connected");
                      }}
                      onDisconnect={() => {
                          console.log("Disconnected");
                      }}
                      onMessage={(msg) => {
                          console.log(msg);
                          console.log('tset3')
                          setConf(msg)
                          //  setResult(msg.result)
                          //setResult(steps[0]?.content)
                          console.log(msg);
                      }}
        />
    </div>
}