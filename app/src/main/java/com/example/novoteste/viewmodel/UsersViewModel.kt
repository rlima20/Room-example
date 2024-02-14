package com.example.novoteste.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.novoteste.dao.UserDao
import com.example.novoteste.mapper.UserMapper
import com.example.novoteste.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsersViewModel(
    private val dao: UserDao,
) : ViewModel() {

    private val _userState: MutableStateFlow<User> = MutableStateFlow(User())
    val userState: StateFlow<User> = _userState

    private val _listOfUsersState: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val listOfUsersState: StateFlow<List<User>> = _listOfUsersState

    init {
        getAllUsers()
    }

    private fun getAllUsers() = viewModelScope.launch {
        dao.getAllUsers().collect {
            val listOfUsers: List<User> = emptyList()
            it.forEach { user ->
                listOfUsers.plus(UserMapper().toMap(user))
            }
            _listOfUsersState.value = listOfUsers
        }
    }

    fun getUserById(id: Int) = viewModelScope.launch {
        dao.getUserById(id).collect {
            _userState.value = UserMapper().toMap(it)
        }
    }

    fun insertUser(user: User) = viewModelScope.launch {
        dao.insertUser(UserMapper().toMap(user))
    }

    fun updateUser(user: User) = viewModelScope.launch {
        dao.updateUser(user.id, user.email, user.user)
    }

    fun deleteUser(user: User) = viewModelScope.launch {
        dao.deleteUser(UserMapper().toMap(user))
    }
}
