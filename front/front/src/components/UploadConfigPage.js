import Card from "antd/es/card";
import React from "react";
import Upload from "antd/es/upload";
import Button from "antd/es/button";
import UploadOutlined from "@ant-design/icons/lib/icons/UploadOutlined";

export default function UploadConfig() {
    return <Card title="Default size card" extra={<a href="#">More</a>} style={{ width: "100%" }}>
        <Upload >
            <Button icon={<UploadOutlined />}>Click to Upload</Button>
        </Upload>
    </Card>
}