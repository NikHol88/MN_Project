import Card from "antd/es/card";
import React, {useState} from 'react';
import TextArea from "antd/es/input/TextArea";
import Button from "antd/es/button";
import axios from "axios";
import SyntaxHighlighter from 'react-syntax-highlighter';
import {docco} from 'react-syntax-highlighter/dist/esm/styles/hljs';
import Popover from "antd/es/popover";

export default function NewsField() {
    const [config, setConfig] = useState('');
    const [result, setResult] = useState();
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(false);

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
    const onChange = (e) => {
        console.log(e)
        setConfig(e.target.value)
    }


   return  <Card title="Default size card" extra={<a href="#">More</a>} style={{ width: "100%" }}>
       <Popover
           title="Error"
           trigger="click"
           content="Incorrect config"
           visible={error}
       >
       <Button onClick={sendConfig}  loading={loading}>test </Button>
       </Popover>
       <div   style={{  display: 'flex'}}>
      <div style={{width: '30%'}}>
      <TextArea rows={30} onChange={onChange} />
      </div>
      <div style={{width: '65%'}}>
        {/*  <SyntaxHighlighter language="htmlbars" style={docco}>
              {result}</SyntaxHighlighter>*/}
         <TextArea rows={30} value={result}
         />
      </div>
       </div>
   </Card>

}
