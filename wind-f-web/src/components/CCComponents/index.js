import CCInput from './CCInput/CCInput.vue';
import CCButton from './CCButton/CCButton.vue';
import CCLink from './CCLink/CCLink.vue';

export default {
  install: (app) => {
    app.component('CCButton', CCButton);
    app.component('CCInput', CCInput);
    app.component('CCLink', CCLink);
  },
};
