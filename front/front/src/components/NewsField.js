import Card from "antd/es/card";
import React, {useEffect, useState} from 'react';
import TextArea from "antd/es/input/TextArea";
import Button from "antd/es/button";
import axios from "axios";
import {docco} from 'react-syntax-highlighter/dist/esm/styles/hljs';
import Popover from "antd/es/popover";
import * as SockJS from 'sockjs-client';
import sendName from "./WS";
import SockJsClient from 'react-stomp';
import { Steps } from 'antd';

export default function NewsField() {
    const [config, setConfig] = useState('');
    const [result, setResult] = useState();
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(false);
    const [message, setMessage] = useState('You server message here.');
    const [steps, setSteps] = useState([]);
    const [current, setCurrent] = React.useState(0);
   // const ws = sendName;
    const { Step } = Steps;
    function handleMessage(stompMessage) {
      console.log(stompMessage)
    }
    const SOCKET_URL = 'http://localhost:8080/ws-message';
   /* const steps = [
        {
            title: 'First',
            content: 'First-content',
            status: 'error'
        },
        {
            title: 'Second',
            content: 'Second-content',
            status: 'error'
        },
        {
            title: 'Last',
            content: 'Last-content',
            status: 'error'
        },
    ];*/
        let onConnected = () => {
            console.log("Connected!!")
        }

        let onMessageReceived = (msg) => {
            console.log(msg)
            setMessage(msg.message);
        }



        const configParsed = () => {
        try {
            console.log('test')
            return JSON.parse(config)
        } catch (e) {
            console.log('test')
            setError(true)
            setTimeout(() => { setError(false)}, 5000);
        }
    }

    const sendConfig = () => {
        const conf = configParsed()
        if (conf) {
            const data = {
                method: 'post',
                url: 'test',
                baseURL: 'http://localhost:8080',
                data: conf
            }
            setLoading(true)
            axios(data).then(result => {
                setResult(result.data)
                setLoading(false)
            }).catch(e => {
                setError(true)
                setTimeout(() => { setError(false)}, 5000);
                setLoading(false)
            })
        }
    }
    const saveConfig = () => {
        const conf = configParsed()
        if (conf) {
            const data = {
                method: 'post',
                url: 'savecofig',
                baseURL: 'http://localhost:8080',
                data: conf
            }
            setLoading(true)
            axios(data).then(result => {
                setResult(result.data)
                setLoading(false)
            }).catch(e => {
                setError(true)
                setTimeout(() => { setError(false)}, 5000);
                setLoading(false)
            })
        }
    }
    const onChange = (e) => {
        console.log(e)
        setConfig(e.target.value)
    }
    const next = () => {
        setCurrent(current + 1);
    };

    const prev = () => {
        setCurrent(current - 1);
    };

   return  <Card title="Default size card" extra={<a href="#">More</a>} style={{ width: "100%" }}>
       <Steps current={current} onChange={(currentNum)=> {
           setCurrent(currentNum)
           setResult(steps[currentNum].content)}
       } >
           {steps.map(item =>
               (  <Step key={item.title} title={item.title} status={item.status} />
              ))
           }
       </Steps>
      {/*   <div className="steps-content">{steps[current]?.content}</div>
       <div className="steps-action">
           {current < steps.length - 1 && (
               <Button type="primary" onClick={() => next()}>
                   Next
               </Button>
           )}
           {current === steps.length - 1 && (
               <Button type="primary" onClick={() => message.success('Processing complete!')}>
                   Done
               </Button>
           )}
           {current > 0 && (
               <Button style={{ margin: '0 8px' }} onClick={() => prev()}>
                   Previous
               </Button>
           )}
       </div>*/}
       <Popover
           title="Error"
           trigger="click"
           content="Incorrect config"
           visible={error}
       >
       <Button onClick={sendConfig}  loading={loading}>test </Button>
           <Button onClick={saveConfig}  loading={loading}>saveConfig </Button>
       </Popover>
       <div   style={{  display: 'flex'}}>
      <div style={{width: '30%'}}>
      <TextArea rows={30} onChange={onChange} />
      </div>
      <div style={{width: '65%'}}>
        {/*  <SyntaxHighlighter language="htmlbars" style={docco}>
              {result}</SyntaxHighlighter>*/}
          <TextArea rows={30} value={result}/>


      </div>
       </div>
      {/* <SockJsClient url={SOCKET_URL}
                     topics={['/topic/message']}
                     onConnect={() => {
                         console.log("connected");
                     }}
                     onDisconnect={() => {
                         console.log("Disconnected");
                     }}
                     onMessage={(msg) => {
                         console.log(msg);

                         setSteps(msg)
                       //  setResult(msg.result)
                         //setResult(steps[0]?.content)
                         console.log(msg);
                     }}
                  />*/}
   </Card>

}
