import { createStore, compose } from 'redux';
import reducers from './reducers';

// const enhancers = compose(
// window.__REDUX_DEVTOOLD_EXTENSION__ && window.__REDUX_DEVTOOLD_EXTENSION__()
// )

const store = createStore(
    reducers,
    // initialState,
    // enhancers
);


export default store;