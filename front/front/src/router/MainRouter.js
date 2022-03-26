import {BrowserRouter as Router, useRoutes,} from "react-router-dom";
import Provider from "react-redux/lib/components/Provider";

import React from "react";
import NewsField from "../components/NewsField";


const Routers = () => {
    return useRoutes([
        {path: "/", element: <NewsField/>},
        /* {path: "test", element: <FirstPage/>},
         {path: "test2", element: <DragAndDropLayer/>}*/
    ]);
};

function MainRouter()  {
    //console.log(store)
    return (
        //<Provider >
            <Router>
                <Routers/>
            </Router>
      //  </Provider>
    );
}
export default MainRouter