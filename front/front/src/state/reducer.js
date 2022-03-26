import {createStore} from "redux";

const INITIAL_STATE = []

function reducer(state, action) {
    switch (action.type) {
        case 'REGISTER_SHOW':
            return [
                ...state,
                {
                    registerModalShow: true
                }
            ]
        case 'REGISTER_SHOW_OFF':
            return [
                ...state,
                {
                    registerModalShow: false
                }
            ]
        default:
            return state
    }
}

function store(){
   return  createStore(reducer, INITIAL_STATE)
}

export default store