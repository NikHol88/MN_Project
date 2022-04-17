import { Layout, Menu, Breadcrumb } from 'antd';
import React from 'react';
import { UserOutlined, LaptopOutlined, NotificationOutlined } from '@ant-design/icons';
import 'antd/dist/antd.css';
import MainRouter from "../router/MainRouter";
import Button from "antd/es/button";
import Space from "antd/es/space";
import store from "../state/store";

const { SubMenu } = Menu;
const { Header, Content, Footer, Sider } = Layout;

function registerAction() {
    store.dispatch({
        type: 'REGISTER_SHOW',
        id: 1
    })
}

function Main() {
    console.log(store.getState)

    return    <Layout>
        <Header className="header">
            <div className="logo" />
            <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['2']}>
                <Menu.Item key="1">nav 1</Menu.Item>
                <Menu.Item key="2">nav 2</Menu.Item>
                <Menu.Item key="3"  onClick={registerAction()}>
                 Register
                </Menu.Item>
                <Menu.Item key="4">Sign in</Menu.Item>
            </Menu>
        </Header>
        <Content style={{ padding: '0 50px' }}>
                    <MainRouter/>
        </Content>
        <Footer style={{ textAlign: 'center' }}>Ant Design ©2018 Created by Ant UED</Footer>

    </Layout>
}

export default Main

