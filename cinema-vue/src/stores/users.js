import { ref, computed } from "vue";
import { defineStore } from "pinia";
import { post } from "@/helpers";
import { config } from '@/app.config.js';

const baseUrl = `${config.baseUrl}/utenti`;

export const useUsersStore = defineStore("users", () => {
  const users = ref({});
  const user = ref({});

  async function registration(user) {
      return await post(`${baseUrl}`, user);
  }

  return { users, user, registration };
});
