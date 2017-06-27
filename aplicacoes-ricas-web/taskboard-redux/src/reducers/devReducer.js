export default function devReducer(state = [], action) {
  switch(action.type) {
    case 'CREATE_DEV':
      return [...state, Object.assign({}, action.dev)];
    default:
      return state;
 }
}