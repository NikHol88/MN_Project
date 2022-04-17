import {BrowserRouter as Router, Link, useRoutes,} from "react-router-dom";
import Provider from "react-redux/lib/components/Provider";

import React, {useEffect} from "react";
import NewsField from "../components/NewsField";
import UploadConfig from "../components/UploadConfigPage";
import { Layout, Menu} from "antd";

import {UserOutlined} from "@ant-design/icons";
import Sider from "antd/es/layout/Sider";
import SubMenu from "antd/es/menu/SubMenu";
import AllConfigs from "../components/AllConfigs";
import {useLocation} from "react-router";


const Routers = () => {
    return useRoutes([
        {path: "/", element: <NewsField/>},
         {path: "upload", element: <UploadConfig/>},
         {path: "configs", element: <AllConfigs/>}
    ]);
};
const {  Content } = Layout;
const map = new Map()
map.set("",1)
map.set("upload",2)
map.set("configs",3)



function MainRouter()  {
    //console.log(store)

    return (
        //<Provider >
            <Router>

                <Layout className="site-layout-background" style={{ padding: '24px 0' }}>
                    <Sider className="site-layout-background" width={200}>
                        <Menu
                            mode="inline"
                            defaultSelectedKeys={[map.get(window.location.href.split('/'))]}
                            defaultOpenKeys={['sub1']}
                            style={{ height: '100%' }}
                        >
                            <SubMenu key="sub1" icon={<UserOutlined />} title="subnav 1">
                                <Menu.Item key="1" >  <Link to='/'>Test config</Link></Menu.Item>
                                <Menu.Item key="2" > <Link to='/upload'>Upload as file</Link></Menu.Item>
                                <Menu.Item key="3" > <Link to='/configs'>Public configurations</Link></Menu.Item>
                            </SubMenu>
                        </Menu>
                    </Sider>
                    <Content style={{ padding: '0 24px', minHeight: 280 }}>

                        <Routers/>
                    </Content>
                </Layout>


            </Router>
      //  </Provider>
    );
}
export default MainRouter