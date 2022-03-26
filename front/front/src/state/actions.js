const setData = (content) => {
    return {
        type: "SET_REGISTER_SHOW",
        content
    }
}

const appendData = (obj) => {
    return (dispatch) => {
        dispatch(setData(obj));
    }
}

export {
    appendData
}